package com.greetingapp.services;

import com.greetingapp.dto.GreetingMessageDTO;
import com.greetingapp.entities.GreetingMessageEntity;
import com.greetingapp.repo.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreetingMessageService {

    final ModelMapper modelMapper;
    final GreetingRepository greetingRepository;

    public GreetingMessageService(ModelMapper modelMapper, GreetingRepository greetingRepository) {
        this.modelMapper = modelMapper;
        this.greetingRepository = greetingRepository;
    }

    public GreetingMessageDTO createMessage(GreetingMessageDTO greetingMessageDTO){
        GreetingMessageEntity greetingMessageEntity = modelMapper.map(greetingMessageDTO , GreetingMessageEntity.class);
        return modelMapper.map(greetingRepository.save(greetingMessageEntity),GreetingMessageDTO.class);
    }

    public List<GreetingMessageDTO> getAllMessages() {

        return greetingRepository
                .findAll()
                .stream()
                .map(greetingMessageEntity -> modelMapper.map(greetingMessageEntity, GreetingMessageDTO.class))
                .collect(Collectors.toList());
    }
}