package logic

import spock.lang.Specification
import spock.lang.Unroll

class ReaderFactoryTest extends Specification {

    @Unroll
    def "shouldReturnProperReader"() {
        when:
        def result = ReaderFactory.choose(filepath)

        then:
        result in expected

        where:
        filepath   || expected
        'test.csv' || CsvReader.class
        'test.prn' || PrnReader.class

    }

}
