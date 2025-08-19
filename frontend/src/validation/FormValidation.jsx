import * as Yup from 'yup';

export const appointmentFormValidation = Yup.object().shape({
    patient_name: Yup.string()
        .min(2, 'Too Short!')
        .max(50, 'Too Long!')
        .required('Patient name is required'),
    patient_age: Yup.number()
        .min(1, 'Invalid age')
        .max(99, 'Invalid age')
        .required('Age is required'),
    address: Yup.string().required('Address is required'),
    contact_number: Yup.string()
        .matches(/^[0-9]{12}$/, 'Contact number must be 10 digits')
        .required('Contact number is required'),
    date: Yup.date().required('Date is required'),
    medical_speciality: Yup.string().required('Speciality is required'),
    select_doc: Yup.string().required('Doctor selection is required'),
    purpose: Yup.string().required('Purpose is required'),
});
