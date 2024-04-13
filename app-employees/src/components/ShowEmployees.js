import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';
import { show_alert } from './functions';
import { Link } from 'react-router-dom/dist';

const ShowEmployees = () => {
	
    const url = 'http://localhost:8080/employee/api/employees';
    const [employees, setEmployees] = useState([]);

    useEffect( ()=>{
        getEmployees();
    }, []);

    const getEmployees = async () => {
      try{
        const answer = await axios.get(url);
        setEmployees(answer.data);
      }
      catch(e){
        console.log(e)
      }
    }

  return (
    <div>
      <h1>EMPLOYEES LIST</h1>
      <div className='container-fluid'>
        <h2>title</h2>
        <div className='row mt-3'>
          <div className='col-12 col-lg-8 offset-0 offset-lg-0'>
            <div className='table-responsive'>
              <div className='table table-bordered'>
                <thead>
                  <tr><th>EMPLOYEE_ID</th><th>FIRST_NAME</th><th>LAST_NAME</th><th>ROLE</th><th>SALARY</th></tr>
                </thead>
                <tbody className='table-group-divider'>
                  {employees.map( (employee,i) => (
                    <tr key={employee.employeeId}>
                      <td>{employee.employeeId}</td>
                      <td>{employee.firstName}</td>
                      <td>{employee.lastName}</td>
                      <td>{employee.role}</td>
                      <td>{employee.salary}</td>
                    </tr>
                  ))
                  }
                </tbody>
              </div>    
            </div>  
          </div>
        </div>
        <Link to="/create">
        	<button>New</button>
        </Link>
      </div>
    </div>
  )
}

export default ShowEmployees
