package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository CommentRepository;

  //The method calls the createComment() method in the Repository and passes the Comment to be inserted in the database
    public void createComment(Comment comment) {
        CommentRepository.createComment(comment);
    }
    
  //The method calls the getComments() method in the Repository and get all comments for image from the database
    public List<Comment> getComments(Image image) {
        List<Comment> comments = CommentRepository.getComments(image);
		return comments;
    }

}
