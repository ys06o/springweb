package example.day02.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/practice2/post") //해당 클래스내 메소드들이 정의하는 url 공통
public class PostController {



    //1.
    @PostMapping
    public boolean 글쓰기(){
        return true;
    }

    //2.컬렉션 프레임워크 []1개:List ,{}1개:Map
    //Map이란? key랑 value 한쌍으로 갖고 엔트리를 갖고 여러개 엔트리 저장->DTO/json 대용
    @GetMapping
    public List<Map<String,Object>> 전체글조회(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map1=new HashMap<>();
        map1.put("pno", "1");
        map1.put("btitle", "제목1");
        Map<String,Object> map2=new HashMap<>();
        map2.put("pno", "2");
        map2.put("btitle", "제목2");
        list.add(map1);
        list.add(map2);
        return list;
    }

    @GetMapping("/view")
    public Map<String,String> 개별글조회(){
        Map<String,String> map1=new HashMap<>();
        map1.put("pno", "1");
        map1.put("btitle", "제목1");
        return map1;
    }

    @PutMapping
    public boolean 개별글수정(){
        return false;
    }

    @DeleteMapping
    public int 개별글삭제(){
        return 3;
    }

} //class end
