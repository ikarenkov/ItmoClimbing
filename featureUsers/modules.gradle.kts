val featureUsersRoot: String by extra

//include(":featureRoutesPresentation")
include(
        ":featureUsers:api",
        ":featureUsers:presentation"
)

//project(":featureRoutesPresentation").projectDir = File(featureRoutesRoot, "featureRoutesPresentation")
//project(":featureUsers").projectDir = File(featureUsersRoot, "featureUsers")