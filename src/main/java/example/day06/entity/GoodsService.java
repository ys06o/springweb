package example.day06.entity;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    //저장
    public boolean 저장(GoodsDto goodsDto){
        //1.dto->entity로 변환
        GoodsEntity goodsEntity=goodsDto.toEntity();

        //2.jpa save를 이용하여 엔티티 insert하기
        GoodsEntity saved=goodsRepository.save(goodsEntity);
        //3.save 결과에 pk여부 성공판단
        if(saved.getGno()>=1){return true;}
        return false;
    } //func end


    //수정
    @Transactional //수정시 여러개 setter를 이용하므로
    public boolean 수정(GoodsDto goodsDto){

        //1.수정할 엔티티의 pk번호를 확인한다.
        int updatePK=goodsDto.getGno();
        //2.수정할 엔티티 찾기--->영속성
        java.util.Optional<GoodsEntity> optional=goodsRepository.findById(updatePK);
        //3.만약에 찾은 엔티티가 존재하면?
        if(optional.isPresent()){
            //존재하면 엔티티 꺼내기
            GoodsEntity updateEntity=optional.get();
            updateEntity.setGdesc(goodsDto.getGdesc());
            updateEntity.setGname(goodsDto.getGname());
            updateEntity.setGprice(goodsDto.getGprice());
            return true;
        }
        else{return false;}
    } //func end



} //class end
