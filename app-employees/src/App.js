import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ShowEmployees from './components/ShowEmployees';
import CreateEmployee from './components/CreateEmployee';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path = '/' element={<ShowEmployees></ShowEmployees>}></Route>
      	<Route path = '/create' element={<CreateEmployee></CreateEmployee>}></Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App;
