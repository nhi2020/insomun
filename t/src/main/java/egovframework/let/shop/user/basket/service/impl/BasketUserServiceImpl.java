package egovframework.let.shop.user.basket.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.basket.service.impl.BasketBuyerMngVO;
import egovframework.let.shop.user.basket.service.BasketUserDAO;
import egovframework.let.shop.user.basket.service.BasketUserService;

@Service("BasketUserService")
public class BasketUserServiceImpl implements BasketUserService {

	@Resource(name="BasketUserDAO")
	BasketUserDAO bd;
	
	@Override
	public BasketUserVO selectBasketUser(BasketUserVO vo) {
		// TODO Auto-generated method stub
		return bd.selectBasketUser(vo);
	}

	@Override
	public List<BasketProductUserVO> listBasketUser(BasketProductUserVO vo) {
		// TODO Auto-generated method stub
		return bd.listBasketUser(vo);
	}

	@Override
	public int listCntBasketUser(BasketProductUserVO vo) {
		// TODO Auto-generated method stub
		return bd.listCntBasketUser(vo);
	}

	@Override
	public int insertBasketUserPro(BasketUserVO vo) {

		return bd.insertBasketUserPro(vo);
	}

}
