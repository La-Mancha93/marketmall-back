✅ 기본 규칙
파일 인코딩: UTF-8

줄바꿈: Unix (LF)

들여쓰기: 탭(Tab) 사용 (스페이스 X)

줄 끝 공백 제거

✅ 파일 구조
1. 라이선스
2. 패키지 선언
3. import 구문
4. 최상위 클래스
각 섹션은 빈 줄 하나로 구분합니다.

✅ import 순서
java.*

(빈 줄)

javax.*, jakarta.*

(빈 줄)

기타 import

(빈 줄)

org.springframework.*

(빈 줄)

static import (테스트에서만 허용)

❌ 와일드카드 import 금지 (import java.util.* 등)

✅ 클래스 구성 순서
static 필드

일반 필드

생성자

생성자 호출용 private 메서드

static 팩토리 메서드

getter/setter

인터페이스 구현 메서드

기타 메서드

equals(), hashCode(), toString()

private 메서드는 사용하는 메서드 바로 아래에 위치

✅ 형식 & 스타일
라인 길이: 권장 90자, 최대 120자

괄호 스타일: K&R 스타일 (이집트 괄호)

삼항 연산자는 괄호로 감싸기

return (foo != null ? foo : "default");

✅ 명명 규칙
항목	형식	예시
상수	UPPER_SNAKE_CASE	DEFAULT_PORT
변수/메서드	lowerCamelCase	getUserById()
클래스	UpperCamelCase	UserService
테스트 클래스	*Tests 접미사	UserServiceTests

❌ 한 글자 변수 지양 → Method method 권장

✅ Null 검사
메서드 인자:
Assert.notNull(param, "Param must not be null");

상태 검사:
Assert.state(obj != null, "Object must not be null");

패키지에 기본 null-safe 설정:
@NonNullApi
@NonNullFields
null 허용 시 @Nullable 명시

✅ Javadoc 규칙
클래스에는 @since 포함

첫 문장은 명령형

여러 문단은 <p> 사용

파라미터 설명은 @param, 반환값은 @return

✅ 테스트 규칙
JUnit 5 (Jupiter) 사용

AssertJ 사용

Mockito로 mock 처리

클래스명은 *Tests로 끝나야 함

✅ 유틸리티 클래스
클래스명: *Utils

abstract + private 생성자

public abstract class MyUtils {
    private MyUtils() {}
}
