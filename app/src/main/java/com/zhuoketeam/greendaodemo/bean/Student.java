package com.zhuoketeam.greendaodemo.bean;

import com.zhuoketeam.greendaodemo.db.ClassRoomDao;
import com.zhuoketeam.greendaodemo.db.DaoSession;
import com.zhuoketeam.greendaodemo.db.StudentDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by Long
 * on 2016/12/1.
 */
@Entity
public class Student {

    @Id(autoincrement = true)
    private Long id;
    private String name;

    private Long classRoomId;

    @ToOne(joinProperty = "classRoomId")
    private ClassRoom classRoom;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;

    @Generated(hash = 61085635)
    public Student(Long id, String name, Long classRoomId) {
        this.id = id;
        this.name = name;
        this.classRoomId = classRoomId;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClassRoomId() {
        return this.classRoomId;
    }

    public void setClassRoomId(Long classRoomId) {
        this.classRoomId = classRoomId;
    }

    @Generated(hash = 241333063)
    private transient Long classRoom__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 729937768)
    public ClassRoom getClassRoom() {
        Long __key = this.classRoomId;
        if (classRoom__resolvedKey == null
                || !classRoom__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ClassRoomDao targetDao = daoSession.getClassRoomDao();
            ClassRoom classRoomNew = targetDao.load(__key);
            synchronized (this) {
                classRoom = classRoomNew;
                classRoom__resolvedKey = __key;
            }
        }
        return classRoom;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1179640613)
    public void setClassRoom(ClassRoom classRoom) {
        synchronized (this) {
            this.classRoom = classRoom;
            classRoomId = classRoom == null ? null : classRoom.getId();
            classRoom__resolvedKey = classRoomId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }

}
