package ssm.service;

import ssm.model.Card;
import ssm.model.CardDetail;

import java.util.List;

/**
 * Created by hongcheng on 17/4/19.
 */
public interface CardService {

    List<Card> getAllCard();

    List<CardDetail> getCardDetailByType(String type);
    boolean deleteCardDetailById(Long id);
    boolean insertCardDetail(CardDetail cardDetail);
    boolean updateCardDetailByType(CardDetail cardDetail);
}
