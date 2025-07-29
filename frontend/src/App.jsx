import { Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';
import Header from './layout/Header';
import Footer from './layout/Footer';
import Doctors from './pages/Doctors';
import WorkInProgress from './pages/WorkInprogress';

function App() {
  return (
    <>
      <Routes>
        <Route path='/' element={<Header />}>
          <Route index element={<Home />} />
          <Route path='doctors' element={<Doctors />} />
          <Route path='*' element={<WorkInProgress />} />
        </Route>
      </Routes>
      <Footer />
    </>
  );
}

export default App;
