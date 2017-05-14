package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.model.CardDetail;

import java.util.List;

/**
 * Created by hongcheng on 17/4/19.
 */
@Repository
public interface CardDetailDao {

    List<CardDetail> selectAllCardDetailByType(@Param("type") String type);
    long deleteCardDetailById(@Param("id") Long id);
    long insertCardDetail(@Param("cardDetail") CardDetail cardDetail);
    long updateCardDetail(@Param("cardDetail") CardDetail cardDetail);
}
