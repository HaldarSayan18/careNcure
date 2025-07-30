import React, { useState } from 'react'
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import PhoneInput from 'react-phone-input-2'
import 'react-phone-input-2/lib/style.css';
import { toast, ToastContainer } from 'react-toastify';

const Appointment = () => {
    const [phone, setPhone] = useState('');
    const handleAppointmentSubmit = () => {
        toast.success("Booked!");
    };
    return (
        <div className='appointment-container'>
            <ToastContainer />
            <h2>Book an Appointment</h2>
            <Form className='appointment-form' method='' action=''>
                <h4>Patient Details</h4>
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridName">
                        <Form.Label><strong>Patient Name</strong></Form.Label>
                        <Form.Control type="text" placeholder="Patient Name" />
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridAge">
                        <Form.Label><strong>Patient Age</strong></Form.Label>
                        <Form.Control type="number" min={0} max={99} placeholder="Patient age" onInput={(e) => {
                            // Restrict more than 2 digits
                            if (e.target.value.length > 2) {
                                e.target.value = e.target.value.slice(0, 2);
                            }
                        }} />
                    </Form.Group>
                </Row>

                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridContact">
                        <Form.Label><strong>Contact Number</strong></Form.Label>
                        <PhoneInput
                            country={'in'}
                            onlyCountries={['in']}
                            value={phone}
                            onChange={setPhone}
                            inputProps={{
                                name: 'phone',
                                required: true,
                                className: 'form-control'
                            }}
                            placeholder='+91-xxxxxxxxx'
                            containerClass='react-tel-input w-100'
                            inputClass='form-control'
                        />
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridPurpose">
                        <Form.Label><strong>Address</strong></Form.Label>
                        <Form.Control type='text' placeholder="Patient Address" />
                    </Form.Group>
                </Row>


                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridMedSpl">
                        <Form.Label><strong>Medical Specialty</strong></Form.Label>
                        <Form.Select defaultValue="Choose Speciality">
                            <option>Choose Speciality</option>
                            <option>Orthopedic</option>
                            <option>Neurologists</option>
                            <option>Cardiologists</option>
                        </Form.Select>
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridSelectDoctor">
                        <Form.Label><strong>Select Doctor</strong></Form.Label>
                        <Form.Select defaultValue="Select Doctor">
                            <option>Select Doctor</option>
                            <option>Dr. Bose</option>
                        </Form.Select>
                    </Form.Group>
                </Row>

                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridDate">
                        <Form.Label><strong>Date</strong></Form.Label>
                        <Form.Control type='date' />
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridTime">
                        <Form.Label><strong>Time</strong></Form.Label>
                        <Form.Control type='time' />
                    </Form.Group>
                </Row>

                <Form.Group className="mb-3" controlId="formGridPurpose">
                    <Form.Label><strong>Purpose of Appointment</strong></Form.Label>
                    <Form.Control type='text' placeholder="Mention your purpose" />
                </Form.Group>

                <Button variant="primary" type="button" onClick={handleAppointmentSubmit} style={{ width: "100%", height: "50px", marginBottom: "5px" }}>
                    Book Appointment
                </Button>
            </Form>
        </div>
    )
}

export default Appointment