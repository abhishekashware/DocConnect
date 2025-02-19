import Home from "assets/images/dashboarsIcons/home.svg";
import Appointments from "assets/images/dashboarsIcons/appointments.svg";
import Messages from "assets/images/dashboarsIcons/messages.svg";
import Funds from "assets/images/dashboarsIcons/funds.svg";
import Emergency from "assets/images/dashboarsIcons/emergency.svg";
import BloodBank from "assets/images/dashboarsIcons/blood-bank.svg";
import Hospital from "assets/images/dashboarsIcons/hospital.svg";
import Medics from 'assets/images/dashboarsIcons/medicines.svg'
import { useSelector } from "react-redux";

const useGetHospitalData = () => {
  const hospitalLogin = useSelector((state) => {
    return state.hospitalLogin;
  });

  let responseObject = { ...hospitalLogin.hospitalInfo };
  let hospitalId = responseObject._id;

  return {
    hospitalMenuData: [
      {
        id: 1,
        route: `/${hospitalId}/hospitalDashboard/`,
        title: "Dashboard",
        icon: Home,
        isDisabled:false
      },
      {
        id: 2,
        route: `/${hospitalId}/hospitalDashboard/appointments/`,
        title: "Appointments",
        icon: Appointments,
        isDisabled:false
      },
      {
        id: 3,
        route: `/${hospitalId}/hospitalDashboard/hospitals/`,
        title: "Hospitals",
        icon: Hospital,
        isDisabled:false
      },
      {
        id: 4,
        route: `/${hospitalId}/hospitalDashboard/messages/`,
        title: "Messages",
        icon: Messages,
        isDisabled:true
      },
      {
        id: 5,
        route: `/${hospitalId}/hospitalDashboard/funds/`,
        title: "Funds",
        icon: Funds,
        isDisabled:true
      },
      {
        id: 6,
        route: `/${hospitalId}/hospitalDashboard/emergency/`,
        title: "Emergency",
        icon: Emergency,
        isDisabled:true
      },
      {
        id: 7,
        route: `/${hospitalId}/hospitalDashboard/blood-bank/`,
        title: "Blood Bank",
        icon: BloodBank,
        isDisabled:true
      },
      {
        id: 8,
        route: `/medicines/`,
        title: "Medicines",
        icon: Medics,
        isDisabled:false
      }
    ],
  };
};

export default useGetHospitalData;
