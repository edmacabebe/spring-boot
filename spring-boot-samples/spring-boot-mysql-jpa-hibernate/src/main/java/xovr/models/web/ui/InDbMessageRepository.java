package xovr.models.web.ui;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


/**
 * 
 * @author emacabebe
 * providing basic crud support
 *
 */
@Repository
@Transactional
public class InDbMessageRepository implements MessageRepository {

	@PersistenceContext
	  private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public Iterable<Message> findAll() {
		return entityManager.createQuery("from Message").getResultList();
		//return null;
	}

	@Override
	public Message save(Message message) {
		entityManager.persist(message);
		return message;
	}

	@Override
	public Message findMessage(Long id) {
		//return null;
		return entityManager.find(Message.class, id);
	}

	@Override
	public void deleteMessage(Long id) {
		//if (m != null) 
		entityManager.remove(entityManager.find(Message.class, id));
		    
	}
	
}
