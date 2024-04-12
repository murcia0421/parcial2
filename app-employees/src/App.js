import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ShowEmployees from './components/ShowEmployees';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path = '/' element={<ShowEmployees></ShowEmployees>}>
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App;
