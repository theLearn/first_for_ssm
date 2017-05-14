package ssm.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.cache.RedisCache;
import ssm.dao.CardDao;
import ssm.dao.CardDetailDao;
import ssm.model.Card;
import ssm.model.CardDetail;
import ssm.service.CardService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hongcheng on 17/4/19.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CardServiceImpl implements CardService {

    private Logger log = Logger.getLogger(CardServiceImpl.class);

    @Autowired
    private RedisCache cache;

    @Resource
    private CardDao cardDao;

    @Resource
    private CardDetailDao cardDetailDao;

    public List<Card> getAllCard() {
        String key = cache.CAHCENAME + "|getAllCard";
        List<Card> result = cache.getListCache(key, Card.class);
        if (result == null) {
            log.info("no cache and put cache");
            result = cardDao.selectAllCard();
            cache.putListCacheWithExpireTime(key, result, 10 * 1000);
        } else {
            log.info("get cache success");
        }
        return result;
    }

    public List<CardDetail> getCardDetailByType(String type) {
        String key = cache.CAHCENAME + "|getCardDetailByType|" + type;
//        List<CardDetail> result = cache.getListCache(key, CardDetail.class);
        List<CardDetail> result = null;
        if(result == null)
        {
            log.info("no cache and put cache");
            result = cardDetailDao.selectAllCardDetailByType(type);
            cache.putListCacheWithExpireTime(key, result, 1 * 1000);
        }
        else
        {
            log.info("get cache success");
        }
        return result;
    }

    @Override
    public boolean deleteCardDetailById(Long id) {
        return cardDetailDao.deleteCardDetailById(id) > 0;
    }

    @Override
    public boolean insertCardDetail(CardDetail cardDetail) {
        return cardDetailDao.insertCardDetail(cardDetail) > 0;
    }

    @Override
    public boolean updateCardDetailByType(CardDetail cardDetail) {
        return cardDetailDao.updateCardDetail(cardDetail) > 0;
    }
}
