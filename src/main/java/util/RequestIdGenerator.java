package util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RequestIdGenerator {

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private final static RequestIdGenerator INSTANCE = new RequestIdGenerator();
    private final static short SEQ_UPPER_LIMIT = 999;
    public Map<Short, Integer> frequency;
    private short sequence = -1;

    private RequestIdGenerator() {
        frequency = new ConcurrentHashMap<Short, Integer>(SEQ_UPPER_LIMIT);
    }

    public static RequestIdGenerator getInstance() {
        return INSTANCE;
    }

    public short nextSequence() {
        if (sequence >= SEQ_UPPER_LIMIT) {
            sequence = 0;
        } else {
            sequence++;
        }
        Integer tmp = frequency.get(sequence);
        if ( tmp == null) {
            frequency.put(sequence, 1);
        } else {
            frequency.put(sequence, ++tmp);
        }
        return sequence;
    }

    public String nexId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String timeStamp = sdf.format(new Date());
        DecimalFormat df = new DecimalFormat("000");
        short sequenceNo = nextSequence();
        return "0049" + timeStamp + df.format(sequenceNo);
    }
}


