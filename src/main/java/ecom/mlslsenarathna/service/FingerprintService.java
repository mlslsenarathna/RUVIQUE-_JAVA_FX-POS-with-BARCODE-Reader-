//package ecom.mlslsenarathna.service;
//
//import com.digitalpersona.onetouch.DPFPTemplate;
//import com.digitalpersona.onetouch.capture.*;
//import com.digitalpersona.onetouch.processing.DPFPEnrollment;
//
//public class FingerprintService {
//
//    private DPFPCapture capture;
//    private DPFPEnrollment enrollment;
//
//    public FingerprintService() {
//        capture = DPFPGlobal.getCaptureFactory().createCapture();
//        enrollment = DPFPGlobal.getEnrollmentFactory().createEnrollment();
//
//        // Event: when the scanner captures data
//        capture.addDataListener(new DPFPDataAdapter() {
//            @Override
//            public void dataAcquired(DPFPDataEvent event) {
//                System.out.println("Fingerprint captured!");
//
//                // Process the sample to create template
//                enrollment.addFeatures(
//                        DPFPGlobal.getFeatureExtractionFactory()
//                                .createFeatureExtraction()
//                                .createFeatures(event.getSample(),
//                                        DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT)
//                );
//
//                // If we have a template ready
//                if (enrollment.getFeaturesNeeded() == 0) {
//                    System.out.println("Template generated!");
//                }
//            }
//        });
//    }
//
//    public void start() {
//        capture.startCapture();
//        System.out.println("Capture started.");
//    }
//
//    public void stop() {
//        capture.stopCapture();
//        System.out.println("Capture stopped.");
//    }
//
//    public DPFPTemplate getTemplate() {
//        return enrollment.getTemplate();
//    }
//}
