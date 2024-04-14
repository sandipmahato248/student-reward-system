package com.swa.sms.avatarservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.swa.sms.avatarservice.dto.AvatarDto;
import com.swa.sms.avatarservice.model.Avatar;
import com.swa.sms.avatarservice.repository.AvatarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvatarService {
	private final AvatarRepository avatarRepository;

	public void saveAvatar(AvatarDto avatarDto) {
		Avatar avatar = new Avatar();
		BeanUtils.copyProperties(avatarDto, avatar);
		avatarRepository.save(avatar);
	}

	public List<AvatarDto> getAllAvatars() {
		return avatarRepository.findAll().stream().map(avatar -> {
			AvatarDto avatarDto = new AvatarDto();
			BeanUtils.copyProperties(avatar, avatarDto);
			return avatarDto;
		}).collect(Collectors.toList());
	}

	public void updateAvatar(String avatarId, AvatarDto avatarDto) {
		Avatar oAvatar = avatarRepository.findById(avatarId).get();
		oAvatar.setHead(avatarDto.getHead());
		oAvatar.setHair(avatarDto.getHair());
		oAvatar.setEye(avatarDto.getEye());
		oAvatar.setEyebrow(avatarDto.getEyebrow());
		oAvatar.setNose(avatarDto.getNose());
		oAvatar.setMouth(avatarDto.getMouth());
		oAvatar.setEars(avatarDto.getEars());
		oAvatar.setHat(avatarDto.getHat());
		oAvatar.setTop(avatarDto.getTop());
		oAvatar.setTopColour(avatarDto.getTopColour());
		oAvatar.setHatColour(avatarDto.getHatColour());
		avatarRepository.save(oAvatar);
	}

	public void deleteAvatar(String avatarId) {
		avatarRepository.deleteById(avatarId);
	}
	
	
}
