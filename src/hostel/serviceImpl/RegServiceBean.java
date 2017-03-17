package hostel.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.daoService.RegDao;
import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;
import hostel.model.MemberEntity;
import hostel.service.RegService;

@Service("regservice")
public class RegServiceBean implements RegService{
	
	@Resource
	private RegDao regdao;

	@Override
	public boolean regUser(MemberEntity me) {
		return regdao.regUser(me);
	}

	@Override
	public boolean regInn(ApplicationEntity ae) {
		// TODO Auto-generated method stub
		return regdao.regInn(ae);
	}

	@Override
	public boolean appInn(ApplicationEntity ae) {
		
		InnEntity ieEntity=new InnEntity();
		
		ieEntity.setInnname(ae.getInnname());
		ieEntity.setMgrname(ae.getMgrname());
		ieEntity.setAddress(ae.getAddress());
		ieEntity.setState(ae.getState());
		ieEntity.setPhone(ae.getPhone());
		ieEntity.setMgremail(ae.getMgremail());
		ieEntity.setPassword(ae.getPassword());
		
		return regdao.appInn(ieEntity);
	}

}
