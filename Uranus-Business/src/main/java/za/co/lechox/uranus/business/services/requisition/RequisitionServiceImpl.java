/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.lechox.uranus.business.services.requisition;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.lechox.uranus.common.model.RequisitionModel;
import za.co.lechox.uranus.model.requisition.Requisition;
import za.co.lechox.uranus.repositories.requisition.RequisitionRepository;

/**
 *
 * @author leratoc
 */
@Service
public class RequisitionServiceImpl implements RequisitionService {

    @Autowired
    private RequisitionRepository requisitionRepo;

    @Override
    @Transactional
    public RequisitionModel createRequisition(RequisitionModel requisitionModel) {
        //Map Model to Entity
        Mapper mapper = new DozerBeanMapper();
        Requisition requisition = mapper.map(requisitionModel, Requisition.class);
        requisitionRepo.createWithItems(requisition, requisition.getRequisitionItems());
        return null;
    }

}
