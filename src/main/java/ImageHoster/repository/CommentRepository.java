package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;


  //The method receives the Image object to be updated in the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    public void createComment(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
    
    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch the comments from the database with corresponding image
    //Returns the comments fetched from the database
    public List<Comment> getComments(Image image) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> typedQuery = em.createQuery("SELECT c from Comment c where c.image =:image", Comment.class).setParameter("image", image);
        List<Comment> comments = typedQuery.getResultList();
        return comments;
    }

}
