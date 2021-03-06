package controller;

import java.sql.SQLException;
import java.util.List;

import model.dto.Dealer;
import model.dto.Ib;
import model.dto.IbLine;
import model.dto.Sku;
import model.service.IbService;
import model.service.IbServiceImpl;
import view.EndView;
import view.FailView;

public class IBController {
	static IbService ibService = new IbServiceImpl();

	/**
	 * 전체 거래처 조회
	 * */
	public static void dealerSelect() {
		try {
			List<Dealer> dealerlist = ibService.dealerSelect();
			EndView.printDealerList(dealerlist);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 *거래처 코드로 sku 상품 검색하기 
	 * */
	public static void skuSelectByDealerId(String dealerId) {
		try {
			List<Sku> skulist = ibService.skuSelectByDealerId(dealerId);
			EndView.printSkuListByDealerId(skulist);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 발주
	 * */
	public static void ibInsert(Ib ib) {
		try {
			ibService.ibInsert(ib);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 발주 내역 보기 (거래처별)
	 * */
//	public static void selectIbByDealerId(String dealerId) {
//		try {
//			List<Ib> list = ibService.selectIbByDealerId(dealerId);
//			EndView.printIb(list);
//		}catch(Exception e) {
//			FailView.errorMessage(e.getMessage());
//		}
//	}

	//	/**
	//	 * 諛쒖＜ �긽�꽭 �궡�뿭
	//	 * */
	//	public static void ibTotal(String ibId) {
	//		try {
	//			List<IbLine> list = ibService.ibTotal(ibId);
	//			EndView.printIbTotal(list);
	//		}catch(Exception e) {
	//			FailView.errorMessage(e.getMessage());
	//		}
	//	}

}
