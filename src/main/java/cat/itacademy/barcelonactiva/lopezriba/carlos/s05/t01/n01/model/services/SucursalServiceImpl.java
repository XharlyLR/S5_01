package cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {

	@Autowired
	SucursalRepository sucursalRepository;

	@Override
    public List<SucursalDTO> findAllSucursal(){
		List<SucursalDTO> sucursalsDTO = new ArrayList<SucursalDTO>();
		for (Sucursal sucursal : sucursalRepository.findAll()) {
			sucursalsDTO.add(new SucursalDTO(sucursal.getNomSucursal(), sucursal.getPaisSucursal(), sucursal.getPk_SucursalID()));
		}
        return sucursalsDTO;
    }

	@Override
	public SucursalDTO findSucursalById(long idSucursal) {
        Optional <Sucursal> optional = sucursalRepository.findById(idSucursal);
        SucursalDTO sucursal = null;
        if (optional.isPresent()) {
        	sucursal = new SucursalDTO(optional.get().getNomSucursal(), optional.get().getPaisSucursal(), optional.get().getPk_SucursalID());
        } else {
            throw new RuntimeException(" Sucursal not found for id :: " + idSucursal);
        }
        return sucursal;
    }

	@Override
    public Sucursal saveSucursal(SucursalDTO sucursalDTO){
		Sucursal sucursal = new Sucursal(sucursalDTO.getNomSucursal(), sucursalDTO.getPaisSucursal());
		sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
    	return sucursalRepository.save(sucursal);
    }

	@Override
    public void deleteSucursalById(long idSucursal){
    	sucursalRepository.deleteById(idSucursal);
    }
	
	@Override
	public Page<SucursalDTO> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		
		List<SucursalDTO> sucursalsDTO = new ArrayList<SucursalDTO>();
		for (Sucursal sucursal : sucursalRepository.findAll(pageable)) {
			sucursalsDTO.add(new SucursalDTO(sucursal.getNomSucursal(), sucursal.getPaisSucursal(), sucursal.getPk_SucursalID()));
		}
		Page<SucursalDTO> pageDTO = new PageImpl<>(sucursalsDTO);

		return pageDTO;
	}
}
