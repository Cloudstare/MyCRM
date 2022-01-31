package com.feli.mycrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Users")
public class UsersController {

    private UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public List<Users> getAllActive(){
        return usersRepository.findAllActive();
    }
    @RequestMapping(value = "/notactive", method = RequestMethod.GET)
    public List<Users> getAllNActive(){
        return usersRepository.findAllNActive();
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Users> getAll(){
        return usersRepository.findAll();
    }

    @RequestMapping(value = "/find/{login}", method = RequestMethod.GET)
    public List<Users> getLogin(@PathVariable String login){
        return usersRepository.findByLoginContaining(login);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Users> create(@RequestBody Users users){
        usersRepository.save(users);

        return usersRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<Users> remove(@PathVariable long id){
        usersRepository.deleteById(id);
        //usersRepository.setIsDeleted(id);
        return usersRepository.findAllActive();
    }
}
