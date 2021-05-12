package org.example.orderbook.schema;

public class AvroManipulator {
//    public byte[] serealizeAvroHttpRequestJSON(
//            AvroHttpRequest request) {
//
//        DatumWriter<AvroHttpRequest> writer = new SpecificDatumWriter<>(
//                AvroHttpRequest.class);
//        byte[] data = new byte[0];
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        Encoder jsonEncoder = null;
//        try {
//            jsonEncoder = EncoderFactory.get().jsonEncoder(
//                    AvroHttpRequest.getClassSchema(), stream);
//            writer.write(request, jsonEncoder);
//            jsonEncoder.flush();
//            data = stream.toByteArray();
//        } catch (IOException e) {
//           // logger.error("Serialization error:" + e.getMessage());
//        }
//        return data;
//    }
//
//    public AvroHttpRequest deSerealizeAvroHttpRequestJSON(byte[] data) {
//        DatumReader<AvroHttpRequest> reader
//                = new SpecificDatumReader<>(AvroHttpRequest.class);
//        Decoder decoder = null;
//        try {
//            decoder = DecoderFactory.get().jsonDecoder(
//                    AvroHttpRequest.getClassSchema(), new String(data));
//            return reader.read(null, decoder);
//        } catch (IOException e) {
//           // logger.error("Deserialization error:" + e.getMessage());
//        }
//        return decoder.
//    }
}
