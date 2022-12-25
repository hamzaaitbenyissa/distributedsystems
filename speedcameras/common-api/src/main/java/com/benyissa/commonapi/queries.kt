package com.benyissa.commonapi
class GetAllRadarsQuery();
data class GetRadarById(
        val radarId:String,
);

data class GetOverSpeedDetectionByRadar(
        val radarId:String,
);

class GetOverSpeedsQuery();

class SubscribeToEventsQuery();
class GetAllOverSpeedsQuery();
class GetAllOverSpeedsByRegistrationNumberQuery(
        val registratioACTIVEnNumber : String,
);

//======================================//
//========= IMatriculation Center ===== //
//======List<Vehicle>================================//

class GetAllVehiclesQuery();
class GetAllOwners();
class GetVehicleByRegistrationNumber(
        val registrationNumber : String,
);

class GetAllContraventions();
class GetContraventionById(
        val contraventionId:String,
);

class GetContraventionByOwner(
        val contraventionByOwner:String,
);

class GetOwnerById(
        val id:String,
);