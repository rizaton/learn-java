package rizaton.database.repository;

import rizaton.database.ConnectionUtil;
import rizaton.database.entity.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {
    @Override
    public void insert(Comment comment) {
        try(Connection conn = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "INSERT INTO comments (email,comment) VALUES (?,?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, comment.getEmail());
                stmt.setString(2, comment.getComment());
                stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        comment.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Comment findById(Integer id) {
        try(Connection conn = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return new Comment(
                                rs.getInt("id"),
                                rs.getString("email"),
                                rs.getString("comment")
                        );
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Comment> findAll() {
        try(Connection conn = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments";
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    List<Comment> comments = new ArrayList<>();
                    while (rs.next()) {
                        comments.add(new Comment(
                                rs.getInt("id"),
                                rs.getString("email"),
                                rs.getString("comment")
                        ));
                    }
                    return comments;
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Comment> findAllByEmail(String email) {
        try(Connection conn = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments WHERE email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                try (ResultSet rs = stmt.executeQuery()) {
                    List<Comment> comments = new ArrayList<>();
                    while (rs.next()) {
                        comments.add(new Comment(
                                rs.getInt("id"),
                                rs.getString("email"),
                                rs.getString("comment")
                        ));
                    }
                    return comments;
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
