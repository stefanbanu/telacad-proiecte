package server.controller.service;

import java.util.ArrayList;
import java.util.List;
import lib.dto.UserDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lib.dto.MesajDTO;
import lib.dto.Raspuns;
import server.controller.dao.MesajDao;
import server.controller.dao.UsersDao;
import server.db.MesajDB;
import server.db.UsersDB;

public class MainService {
    private EntityManagerFactory emf;
    
    private MainService() {
        emf = Persistence.createEntityManagerFactory("Java2C8E1-serverPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    private static final class SingletonHolder {
        private static final MainService INSTANCE = new MainService();
    }
    
    public static MainService getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    public Raspuns register(UserDTO user) {
        EntityManager em = getEntityManager();
        UsersDao usersDao = new UsersDao(em);
        
        try {
            UsersDB u = usersDao.findUser(user.getUsername());
            if (u == null) {
                u = new UsersDB();
                u.setUsername(user.getUsername());
                u.setPassword(user.getPassword());
                
                em.getTransaction().begin();
                usersDao.adaugaUser(u);
                em.getTransaction().commit();
                return new Raspuns(Raspuns.Cod.OK);
            }
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return new Raspuns(Raspuns.Cod.NOTOK);
    }
    
    public UserDTO login(UserDTO user) {
        EntityManager em = getEntityManager();
        UsersDao usersDao = new UsersDao(em);
        
        try {
            UsersDB u = usersDao.findUser(user.getUsername());
            if (u != null && user.getPassword().equals(u.getPassword())) {
                user.setId(u.getId());
                return user;
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return null;
    }
    
    public Raspuns adaugaMesaj(MesajDTO mesaj) {
        EntityManager em = getEntityManager();
        MesajDao mesajDao = new MesajDao(em);
        
        try {
            UsersDB u = new UsersDB();
            u.setId(mesaj.getUser().getId());
            
            MesajDB m = new MesajDB();
            m.setMesaj(mesaj.getMesaj());
            m.setUsersId(u);
            
            em.getTransaction().begin();
            mesajDao.adaugaMesaj(m);
            em.getTransaction().commit();
            return new Raspuns(Raspuns.Cod.OK);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return new Raspuns(Raspuns.Cod.NOTOK);
    }
    
    public List<MesajDTO> getMesaje(UserDTO user) {
        EntityManager em = getEntityManager();
        MesajDao mesajDao = new MesajDao(em);
        List<MesajDTO> listaMesaje = new ArrayList<>();
        
        try {
            UsersDB u = new UsersDB();
            u.setId(user.getId());
            
            List<MesajDB> listaMesajeDB = mesajDao.getAllMesajeByUser(u);
            
            listaMesajeDB.forEach(e -> {
                UserDTO userDTO = new UserDTO();
                userDTO.setId(e.getUsersId().getId());
                userDTO.setUsername(e.getUsersId().getUsername());
                
                MesajDTO m = new MesajDTO();
                m.setId(e.getId());
                m.setMesaj(e.getMesaj());
                m.setUser(userDTO);
                
                listaMesaje.add(m);
            });
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return listaMesaje;
    }
}
