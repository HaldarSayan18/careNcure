import { Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';
import Header from './layout/Header';
import Footer from './layout/Footer';
import WorkInProgress from './pages/WorkInprogress';
import Appointment from './pages/Appointment';
import Doctors from './pages/Doctors';

function App() {
  return (
    <>
      <Routes>
        <Route path='/' element={<Header />}>
          <Route index element={<Home />} />
          <Route path='doctors' element={<Doctors />} />
          <Route path='appointment' element={<Appointment />} />
          <Route path='*' element={<WorkInProgress />} />
        </Route>
      </Routes>
      <Footer />
    </>
  );
}

export default App;
