package com.zhuoketeam.greendaodemo;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.zhuoketeam.greendaodemo.bean.ClassRoom;
import com.zhuoketeam.greendaodemo.bean.Student;
import com.zhuoketeam.greendaodemo.db.ClassRoomDao;
import com.zhuoketeam.greendaodemo.db.StudentDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by Long
 * on 2016/12/1.
 */
@RunWith(AndroidJUnit4.class)
public class AndroidTest {

    private static final String TAG = "GreenDao";

    @Before
    public void init() {

    }

    /**
     * 插入学生
     */
    @Test
    public void insertStudent() {
        StudentDao studentDao = GreenDaoManager.getInstance().getSession().getStudentDao();
        Student student = new Student();
        student.setClassRoomId((long) 1);
        student.setName("刻录机的");
        studentDao.insert(student);
    }

    /**
     * 插入班级
     */
    @Test
    public void insertClassRoom() {
        ClassRoomDao classRoomDao = GreenDaoManager.getInstance().getSession().getClassRoomDao();
        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassName("小学一班");
        classRoom.setCreatTime(System.currentTimeMillis());
        classRoomDao.insert(classRoom);
    }

    /**
     * 查询学生列表
     */
    @Test
    public void queryStudent() {
        StudentDao studentDao = GreenDaoManager.getInstance().getSession().getStudentDao();
        List<Student> list = studentDao.queryBuilder().build().list();
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            Log.e(TAG, "student Name == " + student.getName() + "... student Id == " + student.getId()  + "... classRoonId == " + student.getClassRoomId());
        }
        if(list == null || list.size() == 0) {
            Log.e(TAG, "没有学生数据");
        }
    }

    /**
     * 班级查询
     */
    @Test
    public void queryClassRoom() {
        ClassRoomDao classRoomDao = GreenDaoManager.getInstance().getSession().getClassRoomDao();
        List<ClassRoom> list = classRoomDao.queryBuilder().build().list();
        if(list == null || list.size() == 0) {
            Log.e(TAG, "没有班级数据");
        } else {
            for (int i = 0; i < list.size(); i++) {
                ClassRoom classRoom = list.get(i);
                Log.e(TAG, "classRoomName == " + classRoom.getClassName() + "..creatTime == " + classRoom.getCreatTime());
                for (int j = 0; j < classRoom.getStudents().size(); j++) {
                    Student student = classRoom.getStudents().get(j);
                    Log.e(TAG, "student == " + student.getName());
                }
                Log.e(TAG, "----------------------------");
            }
        }

    }


    /**
     * 修改单个学生
     */
    @Test
    public void updateStudent() {
        Student student = GreenDaoManager.getInstance().getSession().getStudentDao().queryBuilder().where(StudentDao.Properties.Id.eq(1)).build().unique();
        if(student != null) {
            student.setName("修改名字了，哈哈");
            GreenDaoManager.getInstance().getSession().getStudentDao().update(student);
        }
    }

    /**
     * 删除单个学生
     */
    @Test
    public void delStudent() {
        StudentDao studentDao = GreenDaoManager.getInstance().getSession().getStudentDao();
        Student student = studentDao.queryBuilder().where(StudentDao.Properties.Id.eq(1)).unique();
        if(student != null) {
            studentDao.deleteByKey(student.getId());
        }
    }
}
