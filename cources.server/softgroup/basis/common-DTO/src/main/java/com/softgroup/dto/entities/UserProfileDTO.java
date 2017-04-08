package com.softgroup.dto.entities;

/**
 * Created by zigza on 05.04.2017.
 */
public class UserProfileDTO {
  String phoneNumber;
  Long createDateTime;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Long getCreateDateTime() {
    return createDateTime;
  }

  public void setCreateDateTime(Long createDateTime) {
    this.createDateTime = createDateTime;
  }

  public Long getUpdateDateTme() {
    return updateDateTme;
  }

  public void setUpdateDateTme(Long updateDateTme) {
    this.updateDateTme = updateDateTme;
  }

  public String getAvatarUri() {
    return avatarUri;
  }

  public void setAvatarUri(String avatarUri) {
    this.avatarUri = avatarUri;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  Long updateDateTme;
  String avatarUri;
  String name;
  String status;
}
