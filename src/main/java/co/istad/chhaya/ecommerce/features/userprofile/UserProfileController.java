package co.istad.chhaya.ecommerce.features.userprofile;

import co.istad.chhaya.ecommerce.features.userprofile.dto.UpdateUserProfileRequest;
import co.istad.chhaya.ecommerce.features.userprofile.dto.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;


    @PatchMapping("/me")
    public UserProfileResponse updateProfile(
            @RequestBody UpdateUserProfileRequest updateUserProfileRequest
            ) {
        return userProfileService.updateProfile(updateUserProfileRequest);
    }


    @GetMapping("/me")
    public UserProfileResponse me() {
        return userProfileService.me();
    }

}
