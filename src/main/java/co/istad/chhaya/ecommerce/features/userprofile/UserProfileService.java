package co.istad.chhaya.ecommerce.features.userprofile;

import co.istad.chhaya.ecommerce.features.userprofile.dto.UpdateUserProfileRequest;
import co.istad.chhaya.ecommerce.features.userprofile.dto.UserProfileResponse;

public interface UserProfileService {

    UserProfileResponse updateProfile(UpdateUserProfileRequest updateUserProfileRequest);


    UserProfileResponse me();

}
