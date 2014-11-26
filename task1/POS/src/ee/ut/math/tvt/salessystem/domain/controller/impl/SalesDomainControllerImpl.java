package ee.ut.math.tvt.salessystem.domain.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

/**
 * Implementation of the sales domain controller.
 */
public class SalesDomainControllerImpl implements SalesDomainController {
	
	Session session = HibernateUtil.currentSession();
	private static final Logger log = Logger.getLogger(SalesDomainControllerImpl.class);

	public void submitCurrentPurchase(List<SoldItem> goods)
			throws VerificationFailedException {
		try {
			// add solditems to database and for each solditem decrease the stockitem quantity
			for (SoldItem item : goods) {
				session.beginTransaction();
				session.save(item);
				//String name = item.getName();
				// find the current item quantity in stock
				Query item_query = session.createQuery("from StockItem where name=:item_name");
				item_query.setParameter("item_name",item.getName());
	
				List<StockItem> stockitems = item_query.list();
				int current_quantity = stockitems.get(0).getQuantity();
				int sold_quantity = item.getQuantity();
				int new_quantity = current_quantity - sold_quantity;
				// update item quantity
				Query update_query = session.createQuery("update StockItem set quantity=:quantity where name=:name");
				update_query.setParameter("quantity", new_quantity);
				update_query.setParameter("name",item.getName());
				update_query.executeUpdate();
				session.getTransaction().commit();
				session.clear();		
				
				
			}
			
		} catch (Exception e1) {
			log.error("Submitting new solditem failed");
		}
		
	}

	public void cancelCurrentPurchase() throws VerificationFailedException {
		// XXX - Cancel current purchase
	}

	public void startNewPurchase() throws VerificationFailedException {
		// XXX - Start new purchase
	}

	public List<StockItem> loadWarehouseState() {
		// XXX mock implementation
		/*List<StockItem> dataset = new ArrayList<StockItem>();
		StockItem chips = new StockItem(1l, "Lays chips", "Potato chips", 11.0, 5);
		dataset.add(chips);
		*/
		List<StockItem> dataset = new ArrayList<StockItem>();
		dataset = session.createQuery("from StockItem").list();		
		return dataset;
	}

	public void addItemToStock(StockItem item) {
		// if item already exists
		/*try {
			String name = item.getName();
			System.out.println(item);
			System.out.println(name);
			// find the current item quantity in stock
			Query item_query = session.createQuery("from StockItem where name=:name");
			item_query.setParameter("name",item.getName());
			
			System.out.println(item_query);
			List<StockItem> stockitems = item_query.list();
			System.out.println(stockitems);
			int current_quantity = stockitems.get(0).getQuantity();
			int added_quantity = item.getQuantity();
			int new_quantity = current_quantity + added_quantity;
			System.out.println(new_quantity);
			// update item quantity
			Query update_query = session.createQuery("update StockItem set quantity=:new_quantity where name=:name");
			update_query.setParameter("quantity", new_quantity);
			update_query.executeUpdate();
			session.getTransaction().commit();
			session.clear();	
		} catch (Exception e1) {
			*/
		// new item
			session.beginTransaction();
			session.save(item);
			session.getTransaction().commit();
			//log.error("Submitting new solditem failed");
		//}
	}
	
	public void addHistoryItemToDatabase(HistoryItem item) {
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
	}

	public void endSession() {
		HibernateUtil.closeSession();
	}
	public Session getSession(){
		return HibernateUtil.currentSession();
	}

	@Override
	public List<HistoryItem> loadHistoryState() {
		List<HistoryItem> dataset = new ArrayList<HistoryItem>();
		dataset = session.createQuery("from HistoryItem").list();
		System.out.println(dataset);
		return dataset;
	}


}
