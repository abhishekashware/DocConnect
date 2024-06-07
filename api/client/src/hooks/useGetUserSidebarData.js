import Home from 'assets/images/dashboarsIcons/home.svg'
import Appointments from 'assets/images/dashboarsIcons/appointments.svg'
import Messages from 'assets/images/dashboarsIcons/messages.svg'
import Funds from 'assets/images/dashboarsIcons/funds.svg'
import Emergency from 'assets/images/dashboarsIcons/emergency.svg'
import BloodBank from 'assets/images/dashboarsIcons/blood-bank.svg'
import Hospital from "assets/images/dashboarsIcons/hospital.svg";
import Medics from 'assets/images/dashboarsIcons/medicines.svg'
import { useSelector } from 'react-redux'


const useGetUserData = () => {
    const userLogin = useSelector(state => state.userLogin)
    const { userInfo, error } = userLogin
    let userId = userInfo._id
    return ({
        userMenuData: [
            {
                id: 1,
                route: `/${userId}/userDashboard/`,
                title: "Dashboard",
                icon: Home,
                isDisabled:false
            },
            {
                id: 2,
                route: `/${userId}/userDashboard/appointments/`,
                title: "Appointments",
                icon: Appointments,
                isDisabled:false

            },
            {
                id: 3,
                route: `/${userId}/userDashboard/hospitals/`,
                title: "Hospital",
                icon: Hospital,
                isDisabled:false

            },
            {
                id: 4,
                route: `/${userId}/userDashboard/messages/`,
                title: "Messages",
                icon: Messages,
                isDisabled:true

            },
            {
                id: 5,
                route: `/${userId}/userDashboard/funds/`,
                title: "Funds",
                icon: Funds,
                isDisabled:true
            },
            {
                id: 6,
                route: `/${userId}/userDashboard/emergency/`,
                title: "Emergency",
                icon: Emergency,
                isDisabled:true

            },
            {
                id: 7,
                route: `/${userId}/userDashboard/blood-bank/`,
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

        ]
    }
        
    )
}


export default useGetUserData;