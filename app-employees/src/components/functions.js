import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';

export function show_alert(message, icon, target){
    onfocus(target);
    const MySwal = withReactContent(Swal);
    MySwal.fire({
       title:message,
       icon:icon 
    });
}
function onfocus(target){
    if(target !== ''){
        document.getElementById(target).focus();
    }
}