package model.service;

import java.sql.SQLException;
import java.util.List;

import exception.NotFoundException;
import model.dao.IbDAO;
import model.dao.IbDAOImpl;
import model.dto.Dealer;
import model.dto.Ib;
import model.dto.IbLine;
import model.dto.Sku;

public class IbServiceImpl implements IbService {
	private IbDAO ibDao = new IbDAOImpl();
	
	/**
	 * 전체 거래처 조회
	 * */
	@Override
	public List<Dealer> dealerSelect() throws SQLException {
		return ibDao.dealerSelect();
	}

	/**
	 *거래처 코드로 sku 상품 검색하기 
	 * */
	@Override
	public List<Sku> skuSelectByDealerId(String dealerId) throws SQLException {
		List<Sku> skulist = ibDao.skuSelectByDealerId(dealerId);
		if(skulist.size()==0 || skulist.isEmpty()) throw new SQLException("잘못된 코드입니다.");
		return skulist;
	}
	
	/**
	 * 발주
	 * */
	@Override
	public int ibInsert(Ib ib) throws SQLException {
		return ibDao.ibInsert(ib);
	}

	/**
	 * 발주 상세 내역
	 * */
	@Override
	public List<IbLine> ibTotal(String ibId) throws SQLException {
		return ibDao.ibTotal(ibId);
	}

}
