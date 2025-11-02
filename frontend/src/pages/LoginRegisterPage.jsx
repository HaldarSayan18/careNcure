import React from 'react'
import LoginHeader from '../layout/LoginHeader';
import axios from 'axios';
import { useNavigate } from 'react-router-dom'
import { Field, Form, Formik } from 'formik';
import { LoginFormValidation, RegisterFormValidation } from '../validation/FormValidation';
import { toast, ToastContainer } from 'react-toastify';
import { baseURL } from '../assets/API/API';
// import { Nav, Tab, Row, Col, Form, Button } from 'react-bootstrap';

const LoginRegister = () => {
    const navigate = useNavigate();
    // login form submission
    const handleLoginForm = (values, { resetForm }) => {
        axios.post(`${baseURL}/auth/login`, values)
            .then(res => {
                localStorage.setItem("accessToken", res.data.AccessToken);
                localStorage.setItem("refreshToken", res.data.RefreshToken);
                console.log("access token value ===> ", res.data.AccessToken);
                console.log("refresh token value ===> ", res.data.RefreshToken);
                toast('Logged in Successfully!', {
                    position: "top-center",
                    autoClose: 2000,
                    pauseOnHover: true,
                    draggable: true,
                });
                setTimeout(() => navigate('/'), 2000);
            })
            .catch(err => console.error(err));
        resetForm();
    };
    // register form submission
    const handleRegisterForm = (values, { resetForm }) => {
        const payload = {
            ...values,
            mobile: Number(values.mobile)
        }
        axios.post(`${baseURL}/patient/registration`, payload)
            .then((res) => {
                console.log("Registration values ===> ", res.data);
                toast('Registration Successfull! Now Signin', {
                    position: "top-center",
                    autoClose: 2000,
                    pauseOnHover: true,
                    draggable: true,
                });
                setTimeout(() => navigate('/sign'), 2000);
            })
            .catch((err) => {
                console.error("Error:", err);
                toast.error("Something went wrong!", {
                    position: "top-center",
                    autoClose: 2000,
                    pauseOnHover: true,
                    draggable: true,
                });
            });
        resetForm();
        // console.log("Registration values ===> ", values);
    };
    return (
        <>
            <ToastContainer />
            <LoginHeader />
            <div className='loginRegister-tab'>
                <nav>
                    <div className="nav nav-tabs" id="nav-tab" role="tablist">
                        {/* sign-in button */}
                        <button className="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Sign in</button>
                        {/* sign-up button */}
                        <button className="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Sign up</button>
                    </div>
                </nav>
                <div className="tab-content" id="nav-tabContent">
                    <div className="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        {/* login form */}
                        <Formik
                            initialValues={{
                                login: "",
                                password: ""
                            }}
                            validationSchema={LoginFormValidation}
                            onSubmit={handleLoginForm}
                        >
                            {({ errors, touched }) => (
                                <Form className="p-4 shadow rounded bg-white">
                                    <h4 className="text-center mb-3">Welcome Back!</h4>
                                    {/* email */}
                                    <div className="mb-3">
                                        <label className="form-label">Email</label>
                                        <Field type="email" name='login' className="form-control" />
                                        {errors.login && touched.login ? <div className="text-danger">{errors.login}</div> : null
                                        }
                                    </div>
                                    {/* password */}
                                    <div className="mb-3">
                                        <label className="form-label">Password</label>
                                        <Field type="password" name='password' className="form-control" />
                                        {errors.password && touched.password ? <div className="text-danger">{errors.password}</div> : null
                                        }
                                    </div>
                                    <button type="submit" className="btn btn-primary w-100">Sign in</button>
                                </Form>
                            )}
                        </Formik>
                    </div>
                    <div className="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                        {/* Register form */}
                        <Formik
                            initialValues={{
                                firstName: "",
                                lastName: "",
                                email: "",
                                mobile: "",
                                password: "",
                                // confirmPassword: "",
                                address: ""
                            }}
                            validationSchema={RegisterFormValidation}
                            onSubmit={handleRegisterForm}
                        >
                            {({ errors, touched }) => (
                                <Form className="p-4 shadow rounded bg-white">
                                    <h4 className="text-center mb-3">Create Account</h4>
                                    {/* first & last name */}
                                    <div className='row mb-3'>
                                        <div className="col-md-6">
                                            <label className="form-label">First Name</label>
                                            <Field type="text" name='firstName' className="form-control" />
                                            {errors.firstName && touched.firstName ? <div className="text-danger">{errors.firstName}</div> : null
                                            }
                                        </div>
                                        <div className="col-md-6">
                                            <label className="form-label">Last Name</label>
                                            <Field type="text" name='lastName' className="form-control" />
                                            {errors.lastName && touched.lastName ? <div className="text-danger">{errors.lastName}</div> : null
                                            }
                                        </div>
                                    </div>
                                    {/* email & mobile */}
                                    <div className='row mb-3'>
                                        <div className="col-md-6">
                                            <label htmlFor="inputEmail" className="form-label">Email</label>
                                            <Field type="email" name='email' className="form-control" id="inputEmail" />
                                            {errors.email && touched.email
                                                ? <div className="text-danger"> {errors.email}</div> : null
                                            }
                                        </div>
                                        <div className="col-md-6">
                                            <label htmlFor="inputMobile" className="form-label">Mobile no.</label>
                                            <Field type="tel" name='mobile' className="form-control" id="inputMobile" />
                                            {errors.mobile && touched.mobile
                                                ? <div className="text-danger">{errors.mobile}</div> : null}
                                        </div>
                                    </div>
                                    {/* password & confirm-password */}
                                    {/* <div className='row mb-3'> */}
                                    <div className="mb-3">
                                        <label htmlFor="inputPassword" className="form-label">Password</label>
                                        <Field type="password" name='password' className="form-control" id="inputPassword" />
                                        {errors.password && touched.password ? <div className='text-danger'>{errors.password}</div> : null}
                                    </div>
                                    {/* <div className="col-md-6">
                                            <label htmlFor="inputConfirmPassword" className="form-label">Confirm Password</label>
                                            <Field type="password" name='confirmPassword' className="form-control" id="inputConfirmPassword" />
                                            {errors.confirmPassword && touched.confirmPassword ? <div className="text-danger"> {errors.confirmPassword}</div> : null
                                            }
                                        </div> */}
                                    {/* </div> */}
                                    {/* address */}
                                    <div className="mb-3">
                                        <label className="form-label">Address</label>
                                        <Field type="text" name='address' className="form-control" />
                                        {errors.address && touched.address ? <div className="text-danger">{errors.address}</div> : null
                                        }
                                    </div>
                                    <button type="submit" className="btn btn-success w-100">Sign up</button>
                                </Form>
                            )}
                        </Formik>
                    </div>
                </div>
            </div>
        </>
    )
}

export default LoginRegister;