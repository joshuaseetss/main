package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddClaimCommand;
import seedu.address.logic.commands.AddContactCommand;
import seedu.address.logic.commands.AddIncomeCommand;
import seedu.address.logic.commands.ApproveClaimCommand;
import seedu.address.logic.commands.BudgetCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditClaimCommand;
import seedu.address.logic.commands.EditContactCommand;
import seedu.address.logic.commands.EditIncomeCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.GotoCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.RejectClaimCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class FinSecParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddContactCommand.COMMAND_WORD:
            return new AddContactCommandParser().parse(arguments);

        case EditContactCommand.COMMAND_WORD:
            return new EditContactCommandParser().parse(arguments);

        case AddClaimCommand.COMMAND_WORD:
            return new AddClaimCommandParser().parse(arguments);

        case EditClaimCommand.COMMAND_WORD:
            return new EditClaimCommandParser().parse(arguments);

        case AddIncomeCommand.COMMAND_WORD:
            return new AddIncomeCommandParser().parse(arguments);

        case EditIncomeCommand.COMMAND_WORD:
            return new EditIncomeCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case GotoCommand.COMMAND_WORD:
            return new GotoCommandParser().parse(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case ApproveClaimCommand.COMMAND_WORD:
            return new ApproveClaimCommandParser().parse(arguments);

        case RejectClaimCommand.COMMAND_WORD:
            return new RejectClaimCommandParser().parse(arguments);

        case BudgetCommand.COMMAND_WORD:
            return new BudgetCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}