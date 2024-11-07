import com.wora.itlens.models.dtos.surveyEditions.SurveyEditionDto;
import com.wora.itlens.models.entites.Answer;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.models.entites.SurveyEdition;
import com.wora.itlens.repositories.AnswerRepository;
import com.wora.itlens.repositories.QuestionRepository;
import com.wora.itlens.repositories.SubjectRepository;
import com.wora.itlens.repositories.SurveyEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Servicetests {

    @Autowired
    private SurveyEditionRepository surveyEditionRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;


    /*
    * Long id,
        LocalDate creationDate,
        LocalDate startDate,
        LocalDate date,
        int totalParticipantCount,
        int totalQuestionCount,
        int totalAnswerCount
    * */

    public SurveyEditionSummaryDTO getSurveyEditionSummary(Long id) {
        SurveyEdition surveyEdition = surveyEditionRepository.findById(id).orElseThrow();
        List<Subject> subjects = subjectRepository.findBySurveyEditionId(id);

        int totalParticipantCount = subjects.stream()
                .mapToInt(this::getParticipantCountBySubjectId)
                .sum();

        int totalQuestionCount = subjects.stream()
                .mapToInt(this::getQuestionCountBySubjectId)
                .sum();

        int totalAnswerCount = subjects.stream()
                .mapToInt(this::getAnswerCountBySubjectId)
                .sum();

        return new SurveyEditionSummaryDTO(
                surveyEdition.getId(),
                surveyEdition.getCreationDate(),
                surveyEdition.getStartDate(),
                surveyEdition.getDate(),
                totalParticipantCount,
                totalQuestionCount,
                totalAnswerCount
        );
    }

    private SubjectDTO getSubjectDTO(Subject subject) {
        List<Question> questions = questionRepository.findBySubjectId(subject.getId());
        int participantCount = getParticipantCountBySubjectId(subject.getId());

        List<QuestionDTO> questionDTOs = questions.stream()
                .map(this::getQuestionDTO)
                .toList();

        return new SubjectDTO(
                subject.getId(),
                subject.getTitle(),
                questions.size(),
                participantCount,
                questionDTOs
        );
    }

    private QuestionDTO getQuestionDTO(Question question) {
        List<Answer> answers = answerRepository.findByQuestionId(question.getId());
        int answerCount = answers.size();

        List<AnswerPercentageDTO> answerPercentages = answers.stream()
                .map(answer -> getAnswerPercentageDTO(answer, answerCount))
                .toList();

        return new QuestionDTO(
                question.getId(),
                question.getText(),
                answerCount,
                answerPercentages
        );
    }

    private AnswerPercentageDTO getAnswerPercentageDTO(Answer answer, int totalAnswers) {
        double percentage = (answer.getSelectionCount() / (double) totalAnswers) * 100;
        return new AnswerPercentageDTO(
                answer.getText(),
                percentage
        );
    }

    private int getParticipantCountBySubjectId(Long subjectId) {
        // Implement logic to get participant count by subject ID
        return 0;
    }

    private int getQuestionCountBySubjectId(Long subjectId) {
        // Implement logic to get question count by subject ID
        return 0;
    }

    private int getAnswerCountBySubjectId(Long subjectId) {
        // Implement logic to get answer count by subject ID
        return 0;
    }
}