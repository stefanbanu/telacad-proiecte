package db;

import db.MesajDB;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-17T17:06:45")
@StaticMetamodel(UsersDB.class)
public class UsersDB_ { 

    public static volatile SingularAttribute<UsersDB, String> password;
    public static volatile CollectionAttribute<UsersDB, MesajDB> mesajDBCollection;
    public static volatile SingularAttribute<UsersDB, Integer> id;
    public static volatile SingularAttribute<UsersDB, String> username;

}