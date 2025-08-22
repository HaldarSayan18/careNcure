package com.careNcure.backend.doctor;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController{
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addDoctor(@RequestParam DoctorDTO doctorDTO,@RequestParam Multipartfile multiipartfile){
        try{
            doctorService.addDoctor(doctorDTO,multiipartfile);
            return ResponseEntity.Status(HttpStatus.CREATED).body(()->new ApiResponse("Doctor added successfully",true));
        }catch(Exception e){
            return ResponseEntity.Status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage(), false));
        }
    }

}