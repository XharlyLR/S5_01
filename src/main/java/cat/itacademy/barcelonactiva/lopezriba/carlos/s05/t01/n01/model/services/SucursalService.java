package cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.services;

import java.util.List;

import org.springframework.data.domain.Page;

import cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.dto.SucursalDTO;

public interface SucursalService {

    public List<SucursalDTO> findAllSucursal();
//    public Optional<Sucursal> findSucursalById(long idSucursal);
    SucursalDTO findSucursalById(long idSucursal);
//    public List<Sucursal> findSucursalByNomContaining(String nomSucursal);
    public Sucursal saveSucursal(SucursalDTO sucursal);
    public void deleteSucursalById(long idSucursal);

	public Page<SucursalDTO> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}