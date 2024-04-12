import React, {useEffect, useState} from 'react'
import axios from 'axios';
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';
import { show_alert } from './functions';

const ShowEmployees = () => {
    const url = 'http://localhost:8080/configuration/example/api/configurations';
    const [configurations, setConfigurations] = useState([]);
    const [propiedad, setPropiedad] = useState('');
    const [valor, setValor] = useState('');
    const [operation, setOperation] = useState(1);
    const [title, setTitle] = useState('');

    useEffect( ()=>{
        getConfigurations();
    }, []);

    const getConfigurations = async () => {
      console.log("HOLA MUNDO") ;
      try{
        const answer = await axios.get(url);
        console.log("-->" );
        console.log(answer.data);
        setConfigurations(answer.data);
      }
      catch(e){
        console.log(e)
      }
  
    }

  return (
    <div>
      <h1>EMPLOYEE LIST</h1>
      <div className='container-fluid'>
        <h2>title</h2>
        <div className='row mt-3'>
          <div className='col-12 col-lg-8 offset-0 offset-lg-0'>
            <div className='table-responsive'>
              <div className='table table-bordered'>
                <thead>
                  <tr><th>#</th><th>propiedad</th><th>valor</th></tr>
                </thead>
                <tbody className='table-group-divider'>
                  {configurations.map( (configuration,i) => (
                    <tr key={configuration.propiedad}>
                      <td>{(i+1)}</td>
                      <td>{configuration.propiedad}</td>
                      <td>{configuration.valor}</td>
                    </tr>
                  ))
                  }
                </tbody>
              </div>    
            </div>  
          </div>
        </div>
      </div>
    </div>
  )
}

export default ShowEmployees
