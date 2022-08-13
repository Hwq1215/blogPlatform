package com.example.coinsblog.service;

import com.example.coinsblog.mapper.HoleMapper;
import com.example.coinsblog.pojo.Hole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HoleService {
    @Autowired
    HoleMapper holeMapper;

    public void addHole(Hole hole){
        holeMapper.addHole(hole);
    }

    public Hole getHoleById(Integer id){
        return holeMapper.getHoleById(id);
    }

    public List<Hole> getHoles(){
        return holeMapper.getAllHoles();
    }
    public void delHole(Integer id){
       holeMapper.deleteHole(id);
    }
    public void updateHole(Hole hole){
        holeMapper.updateHole(hole);
    }
}
