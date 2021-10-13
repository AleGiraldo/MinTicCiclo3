package com.usa.ciclo3.service;

import com.usa.ciclo3.model.Room;
import com.usa.ciclo3.repository.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ale Giraldo
 */
@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;
    
    public List<Room> getAll(){
        return roomRepository.getAll();
    }
    
    public Optional<Room> getRoom(Integer id){
        return roomRepository.getRoom(id);
    }
    
    public Room save(Room room){
        if(room.getId() == null){
            return roomRepository.save(room);
        } else {
            Optional<Room> roomAux = roomRepository.getRoom(room.getId());
            if(roomAux.isEmpty()){
                return roomRepository.save(room);
            } else {
                return room; //Lo retorna pero no lo guarda
            }
        }
    }
}
