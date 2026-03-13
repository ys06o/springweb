package example.day07.practice7.service;

import example.day07.practice7.entity.CourseEntity;
import example.day07.practice7.entity.EnrollEntity;
import example.day07.practice7.entity.StudentEntity;
import example.day07.practice7.repository.CourseRepository;
import example.day07.practice7.repository.EnrollRepository;
import example.day07.practice7.repository.StudentRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class EnrollService {
    @Autowired private EnrollRepository enrollRepository;
    @Autowired private StudentRepsitory studentRepsitory;
    @Autowired private CourseRepository  courseRepository;



    //1.과정등록
    public boolean 과정등록(Map<String,Object> map){
        //1.map,dto 를 entity로 변환한다.
        CourseEntity courseEntity=new CourseEntity();
        courseEntity.setCourseName(map.get("courseName").toString());
        //2.변환된 entity를 저장한다.
        CourseEntity saved =courseRepository.save(courseEntity);
        //반환된 pk값 확인
        if(saved.getCourseId()>=1){
            return true;
        }
        else{
            return false;
        }
    } //func end


    //2.학생등록
    public boolean 학생등록(Map<String,Object> map){
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setStudentName(map.get("studentName").toString());
        StudentEntity saved=studentRepsitory.save(studentEntity);

        if(saved.getStudentId()>=1){
            return true;
        }
        else{
            return false;
        }
    } //func end


    //3.수강등록
    public boolean 수강등록(Map<String, Object> map) {
        //1.수강신청 엔티티 생성
        EnrollEntity saveEntity=new EnrollEntity();
        saveEntity.setStatus(map.get("status").toString());

                /* FK에 해당하는 엔티티 대입*/
        //1.FK 확인 DTO/MAP 등등
        int courseId=Integer.parseInt(String.valueOf(map.get("courseId")));
        //2.해당하는 엔티티를 찾는다.
       Optional<CourseEntity> optionalCourseEntity=courseRepository.findById(courseId);
       if(optionalCourseEntity.isPresent()){ //만약에 엔티티가 존재하면?
           CourseEntity courseEntity=optionalCourseEntity.get(); //엔티티 꺼내기
           saveEntity.setCourseEntity(courseEntity); //FK엔티티를단방향에 저장한다.
       }else{return false;}

       int studentId=Integer.parseInt(String.valueOf(map.get("studentId")));
       Optional<StudentEntity> optionalStudent=studentRepsitory.findById(studentId);
       if(optionalStudent.isPresent()){
           StudentEntity studentEntity=optionalStudent.get();
           saveEntity.setStudentEntity(studentEntity);
       }else{return false;}
        //2.저장한다.
        EnrollEntity saved=enrollRepository.save(saveEntity);

        if(saved.getEnrollId()>=1){
            return true;
        }
        else{
            return false;
        }
    } //func end


    //4.개별 수강정보 조회
    public Map<String, Object> get(int enrollId) {
        //1. enrollId에 해당하는 엔티티 찾기
        Optional<EnrollEntity> enrollEntityOptinal=enrollRepository.findById(enrollId);
        if (enrollEntityOptinal.isPresent()) { //만약에 존재하면?
            EnrollEntity entity=enrollEntityOptinal.get(); //수강 엔티티 정보 꺼내기
            //map을 하나 만들어서 엔티티를 map으로 변환한다.
            Map<String,Object> map=new HashMap<>();
            map.put("enrollId",entity.getEnrollId());
            map.put("status",entity.getStatus());
            map.put("createAt",entity.getCreateAt());
            map.put("updateAt",entity.getUpdateAt());
            map.put("courseName",entity.getCourseEntity().getCourseName());
            map.put("studentName",entity.getStudentEntity().getStudentName());
            return map;
        }
        return null;
    }  //func end

} //class end
