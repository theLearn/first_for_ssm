package ssm.dao;

import org.springframework.stereotype.Repository;
import ssm.model.Card;

import java.util.List;

/**
 * Created by hongcheng on 17/4/19.
 */
@Repository
public interface CardDao {

    List<Card> selectAllCard();
}
